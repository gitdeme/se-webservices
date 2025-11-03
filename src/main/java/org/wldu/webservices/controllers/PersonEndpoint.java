package org.wldu.webservices.controllers;

import com.wldu.xsdgenerated.*;
import org.springframework.ws.server.endpoint.annotation.*;
import org.wldu.webservices.repositories.PersonRepository;
///  SOAP services
@Endpoint
public class PersonEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/person";
    private final PersonRepository personRepository;

    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPersonRequest")
    @ResponsePayload
    public CreatePersonResponse createPerson(@RequestPayload CreatePersonRequest request) {
        Person person = request.getPerson();
        personRepository.create(person);
        CreatePersonResponse response = new CreatePersonResponse();
        response.setStatus("Created successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
        Person person = personRepository.read(request.getFirstName(), request.getLastName());
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(person);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePersonRequest")
    @ResponsePayload
    public UpdatePersonResponse updatePerson(@RequestPayload UpdatePersonRequest request) {
        Person updated = personRepository.update(request.getPerson());
        UpdatePersonResponse response = new UpdatePersonResponse();
        response.setStatus("Updated successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePersonRequest")
    @ResponsePayload
    public DeletePersonResponse deletePerson(@RequestPayload DeletePersonRequest request) {
        boolean deleted = personRepository.delete(request.getFirstName(), request.getLastName());
        DeletePersonResponse response = new DeletePersonResponse();
        response.setStatus(deleted ? "Deleted successfully" : "Person not found");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listPersonsRequest")
    @ResponsePayload
    public ListPersonsResponse listPersons() {
        ListPersonsResponse response = new ListPersonsResponse();
        response.getPersons().addAll(personRepository.listAll());
        return response;
    }
}