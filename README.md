# Contact Management Application
This a springboot application which maintains a record of user contacts in the database and allows you to view, modify or delete them. It's uses the jwt for authenticating and authorizing the users.

## Current status
1. It is currently deployed on heroku .
2. It uses HSQL Db (In-memory Db).
3. User password is stored in the database using BCryptPasswordEncoder

## Features
1. Add contact: Allows you add new contacts in the application database.
2. View contact: You can view all the available active contacts from the database.
3. Edit contact: Allows you to edit and update the contact details of existing user.
4. Delete contact: You can deactivate/delete an existing contact in the database.

### Login/Signup:
User need to create credentials first using signup and then login to get authentication token.

## REST Endpoints
The bot includes following endpoints:

 ### 1. POST: /contacts/add
Allows you to add a new contact

Body parameters:
```bash
  {
  "firstName" = "First name of user",
  "lastName" = "last name of user",
  "email" = "email id of user",
  "phone" = phone number
  }
```

### 2. GET: /contacts/list

Retrieves all the contacts from the database and displays in the below format:

```bash
  [
  {
  "firstName" = "First name of user",
  "lastName" = "last name of user",
  "email" = "email id of user",
  "phone" = phone number
  },
  ....
  ]
```

### 3. PATCH: /contacts/edit

Allows user to edit or update their existing contact details

Body parameters:
```bash
  {
  "firstName" = "First name of user",
  "lastName" = "last name of user",
  "email" = "email id of user",
  "phone" = phone number
  }
```

### 4. DELETE: /contacts/inactivate

Allows user to deactivate existing contact

Query parameter: phone or email
```bash
  "email" = "email id of user";
  "phone" = phone number;
```

### 5. POST: /login
Service for user login
Body parameters:
```bash
  {
  "username" = "",
  "password" = ""
  }
```

### 6. POST: /users/signup
Service to create new user in database
Body parameters:
```bash
  {
  "username" = "",
  "password" = ""
  }
```

### 7. GET: /users/ping
Extra service created to keep the application alive inside heroku. Return a simple string (No Auth reqd)

## Usage:

1. Login to the application using registered username and password

2. Upon successful authorization and authentication, you'll receive an Authorization token in response header in this format:

```python
Authorization: Bearer random_token_values
```

![tokenHeader](https://user-images.githubusercontent.com/41896871/134681895-053b8b79-6fb3-4ee6-9eaa-de8df1b9f632.JPG)

3. Pass this token to other REST endpoints in headers in same format while making a request.
![tokenAuth](https://user-images.githubusercontent.com/41896871/134681761-3d7f3b86-8024-4bdb-87a8-d8bb6d1fce47.JPG)

## Limitations:
1. This application uses inMemory sql db (HSQL) to store the data.
2. An active contact is uniquely identified by either email or phone number.
3. Since this app is deployed on heroku, a job has been created on CronJobs which will ping the application after certain time so as to mark the application as active inside heroku and keep it alive.
4. For using edit contact service, we cannot paas both updated phone and email (because of #2). Either supply one of them or deactivate the contact using deactivate service first.
5. Only the active contacts are being retrieved from the database.
6. Deletion of contact means soft delete, i.e; it's status will be marked as inactive.
