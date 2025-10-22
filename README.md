# BankingApplication

# Beneficiary Module

This module handles the **CRUD operations** for banking beneficiaries as part of the Banking Application. 

## Features

- Add a new beneficiaryModel
- View all beneficiaries
- View a beneficiaryModel by ID
- Update beneficiaryModel details
- Delete a beneficiaryModel

## Tech Stack
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (in-memory for development)
- Maven


Method  Endpoint                             Description
GET     api/v1/accounts/beneficiaries        Get list of beneficiaries
GET     api/v1/accounts/beneficiaries/{id}   Get a single com.hexaware.bankmangementsystem.beneficiary by ID
POST    api/v1/accounts/beneficiaries        Create a new com.hexaware.bankmangementsystem.beneficiary
PUT     api/v1/accounts/beneficiaries/{id}   Update a com.hexaware.bankmangementsystem.beneficiary by ID
DELETE  api/v1/accounts/beneficiaries/{id}   Delete a com.hexaware.bankmangementsystem.beneficiary by ID


