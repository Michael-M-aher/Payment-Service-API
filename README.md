
# Payment Service API

A Spring Boot REST API, that handles payment to various Service Providers, documented with Swagger2.
* Swagger JSON URL: http://localhost:8080/v2/api-docs

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/eg/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3.x](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org/download/) (if you want to run offline databse)



## How to Run 

* Clone this repository 
* download maven dependencies in ``pom.xml`` file
* Postegress database is deployed online.
* execute the `main` method in the `com.m_code.Fawry` class from your IDE.

Once the application runs you should see something like this

```
2023-01-01 19:07:33.598  INFO 14948 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-01-01 19:07:33.899  INFO 14948 --- [           main] com.m_code.Fawry.FawryApplication        : Started FawryApplication in 4.963 seconds (JVM running for 5.296)
```

## Configure PostgreSQL database for the application

- Create a Database in postgresql

- change this code

```
# database config
spring.datasource.url=jdbc:postgresql://localhost:5432/'yourdatabase name'
spring.datasource.username='username'
spring.datasource.password='password'
```

- Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
- All done


## Documentation

```json
{
  "swagger": "2.0",
  "info": {
    "description": "A Spring Boot REST API, that handles payment to various Service Providers, documented with Swagger2.",
    "version": "1.0",
    "title": "Fawry-Api",
    "contact": {},
    "license": {
      "name": "MIT License",
      "url": "https://opensource.org/licenses/MIT"
    }
  },
  "host": "localhost:8080",
  "basePath": "/",
  "tags": [
    {
      "name": "auth-controller",
      "description": "Auth Controller"
    },
    {
      "name": "discount-controller",
      "description": "Discount Controller"
    },
    {
      "name": "donation-service-controller",
      "description": "Donation Service Controller"
    },
    {
      "name": "internet-service-controlller",
      "description": "Internet Service Controlller"
    },
    {
      "name": "landline-service-controller",
      "description": "Landline Service Controller"
    },
    {
      "name": "mobile-service-controller",
      "description": "Mobile Service Controller"
    },
    {
      "name": "service-controller",
      "description": "Service Controller"
    },
    {
      "name": "transaction-controller",
      "description": "Transaction Controller"
    },
    {
      "name": "user-controller",
      "description": "User Controller"
    },
    {
      "name": "wallet-controller",
      "description": "Wallet Controller"
    }
  ],
  "paths": {
    "/api/account": {
      "get": {
        "tags": [
          "user-controller"
        ],
        "summary": "userAccess",
        "operationId": "userAccessUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/auth/refreshtoken": {
      "post": {
        "tags": [
          "auth-controller"
        ],
        "summary": "refreshtoken",
        "operationId": "refreshtokenUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/auth/signin": {
      "post": {
        "tags": [
          "auth-controller"
        ],
        "summary": "authenticateUser",
        "operationId": "authenticateUserUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "loginRequest",
            "description": "loginRequest",
            "required": true,
            "schema": {
              "$ref": "#/definitions/LoginRequest"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/auth/signout": {
      "get": {
        "tags": [
          "auth-controller"
        ],
        "summary": "logoutUser",
        "operationId": "logoutUserUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/auth/signup": {
      "post": {
        "tags": [
          "auth-controller"
        ],
        "summary": "registerUser",
        "operationId": "registerUserUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "signUpRequest",
            "description": "signUpRequest",
            "required": true,
            "schema": {
              "$ref": "#/definitions/SignupRequest"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/discounts/add/overall": {
      "post": {
        "tags": [
          "discount-controller"
        ],
        "summary": "overall",
        "operationId": "overallUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "value",
            "description": "value",
            "required": true,
            "schema": {
              "type": "object",
              "additionalProperties": {
                "type": "number",
                "format": "float"
              }
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/discounts/add/specific": {
      "post": {
        "tags": [
          "discount-controller"
        ],
        "summary": "specific",
        "operationId": "specificUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "discountDto",
            "description": "discountDto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/DiscountDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/discounts/getall": {
      "get": {
        "tags": [
          "discount-controller"
        ],
        "summary": "getDiscounts",
        "operationId": "getDiscountsUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/discounts/remove": {
      "post": {
        "tags": [
          "discount-controller"
        ],
        "summary": "RemoveDiscount",
        "operationId": "RemoveDiscountUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "value",
            "description": "value",
            "required": true,
            "schema": {
              "type": "object",
              "additionalProperties": {
                "type": "integer",
                "format": "int32"
              }
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/donations/{name}/getbill": {
      "get": {
        "tags": [
          "donation-service-controller"
        ],
        "summary": "getBill",
        "operationId": "getBillUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/DonationsPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/donations/{name}/pay/balance": {
      "post": {
        "tags": [
          "donation-service-controller"
        ],
        "summary": "pay",
        "operationId": "payUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/DonationsPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/donations/{name}/pay/cod": {
      "post": {
        "tags": [
          "donation-service-controller"
        ],
        "summary": "paycod",
        "operationId": "paycodUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/DonationsPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/donations/{name}/pay/creditcard": {
      "post": {
        "tags": [
          "donation-service-controller"
        ],
        "summary": "payCreditCard",
        "operationId": "payCreditCardUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/DonationsPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/internet/{name}/getbill": {
      "get": {
        "tags": [
          "internet-service-controlller"
        ],
        "summary": "getBill",
        "operationId": "getBillUsingGET_1",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/InternetPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/internet/{name}/pay/balance": {
      "post": {
        "tags": [
          "internet-service-controlller"
        ],
        "summary": "pay",
        "operationId": "payUsingPOST_1",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/InternetPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/internet/{name}/pay/cod": {
      "post": {
        "tags": [
          "internet-service-controlller"
        ],
        "summary": "paycod",
        "operationId": "paycodUsingPOST_1",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/InternetPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/internet/{name}/pay/creditcard": {
      "post": {
        "tags": [
          "internet-service-controlller"
        ],
        "summary": "payCreditCard",
        "operationId": "payCreditCardUsingPOST_1",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/InternetPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/landline/{name}/getbill": {
      "get": {
        "tags": [
          "landline-service-controller"
        ],
        "summary": "getBill",
        "operationId": "getBillUsingGET_2",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/LandlinePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/landline/{name}/pay/balance": {
      "post": {
        "tags": [
          "landline-service-controller"
        ],
        "summary": "pay",
        "operationId": "payUsingPOST_2",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/LandlinePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/landline/{name}/pay/cod": {
      "post": {
        "tags": [
          "landline-service-controller"
        ],
        "summary": "paycod",
        "operationId": "paycodUsingPOST_2",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/LandlinePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/landline/{name}/pay/creditcard": {
      "post": {
        "tags": [
          "landline-service-controller"
        ],
        "summary": "payCreditCard",
        "operationId": "payCreditCardUsingPOST_2",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/LandlinePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/mobile/{name}/getbill": {
      "get": {
        "tags": [
          "mobile-service-controller"
        ],
        "summary": "getBill",
        "operationId": "getBillUsingGET_3",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/MobilePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/mobile/{name}/pay/balance": {
      "post": {
        "tags": [
          "mobile-service-controller"
        ],
        "summary": "payBalance",
        "operationId": "payBalanceUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/MobilePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/mobile/{name}/pay/cod": {
      "post": {
        "tags": [
          "mobile-service-controller"
        ],
        "summary": "paycod",
        "operationId": "paycodUsingPOST_3",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/MobilePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/mobile/{name}/pay/creditcard": {
      "post": {
        "tags": [
          "mobile-service-controller"
        ],
        "summary": "payCreditCard",
        "operationId": "payCreditCardUsingPOST_3",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "path",
            "description": "name",
            "required": true,
            "type": "string"
          },
          {
            "in": "body",
            "name": "paymentdto",
            "description": "paymentdto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/MobilePaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/services/search": {
      "get": {
        "tags": [
          "service-controller"
        ],
        "summary": "search",
        "operationId": "searchUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "name",
            "in": "query",
            "description": "name",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "array",
              "items": {
                "type": "string"
              }
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/getall": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getAll",
        "operationId": "getAllUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/getpayment": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getPayment",
        "operationId": "getPaymentUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/getrefunded": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getRefund",
        "operationId": "getRefundUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/getwallet": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getWallet",
        "operationId": "getWalletUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/refundrequests/accept": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "acceptRefundRequests",
        "operationId": "acceptRefundRequestsUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/refundrequests/get": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getRefundRequests",
        "operationId": "getRefundRequestsUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/admin/refundrequests/reject": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "declineRefundRequests",
        "operationId": "declineRefundRequestsUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/getall": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "getUserAll",
        "operationId": "getUserAllUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/transactions/refund": {
      "get": {
        "tags": [
          "transaction-controller"
        ],
        "summary": "refund",
        "operationId": "refundUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "name": "jwtToken",
            "in": "query",
            "description": "jwtToken",
            "required": false,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/wallet/addmoney": {
      "post": {
        "tags": [
          "wallet-controller"
        ],
        "summary": "addMoney",
        "operationId": "addMoneyUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "jwtToken",
            "description": "jwtToken",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "in": "body",
            "name": "walletPaymentDto",
            "description": "walletPaymentDto",
            "required": true,
            "schema": {
              "$ref": "#/definitions/WalletPaymentDto"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    }
  },
  "definitions": {
    "CreditCardDto": {
      "type": "object",
      "properties": {
        "cardholdername": {
          "type": "string"
        },
        "cardnumber": {
          "type": "string"
        },
        "cvv": {
          "type": "string"
        },
        "expirationdate": {
          "type": "string"
        }
      },
      "title": "CreditCardDto"
    },
    "DiscountDto": {
      "type": "object",
      "properties": {
        "amount": {
          "type": "number",
          "format": "float"
        },
        "service": {
          "type": "string"
        }
      },
      "title": "DiscountDto"
    },
    "DonationsForm": {
      "type": "object",
      "properties": {
        "donationamount": {
          "type": "string"
        }
      },
      "title": "DonationsForm"
    },
    "DonationsPaymentDto": {
      "type": "object",
      "properties": {
        "creditcard": {
          "$ref": "#/definitions/CreditCardDto"
        },
        "form": {
          "$ref": "#/definitions/DonationsForm"
        }
      },
      "title": "DonationsPaymentDto"
    },
    "InternetPaymentDto": {
      "type": "object",
      "properties": {
        "creditcard": {
          "$ref": "#/definitions/CreditCardDto"
        },
        "form": {
          "$ref": "#/definitions/InternetPaymentForm"
        }
      },
      "title": "InternetPaymentDto"
    },
    "InternetPaymentForm": {
      "type": "object",
      "properties": {
        "landlinenumber": {
          "type": "string"
        }
      },
      "title": "InternetPaymentForm"
    },
    "LandlineForm": {
      "type": "object",
      "properties": {
        "landlinenumber": {
          "type": "string"
        }
      },
      "title": "LandlineForm"
    },
    "LandlinePaymentDto": {
      "type": "object",
      "properties": {
        "creditcard": {
          "$ref": "#/definitions/CreditCardDto"
        },
        "form": {
          "$ref": "#/definitions/LandlineForm"
        }
      },
      "title": "LandlinePaymentDto"
    },
    "LoginRequest": {
      "type": "object",
      "properties": {
        "password": {
          "type": "string"
        },
        "username": {
          "type": "string"
        }
      },
      "title": "LoginRequest"
    },
    "MobilePaymentDto": {
      "type": "object",
      "properties": {
        "creditcard": {
          "$ref": "#/definitions/CreditCardDto"
        },
        "form": {
          "$ref": "#/definitions/MobileRechargeForm"
        }
      },
      "title": "MobilePaymentDto"
    },
    "MobileRechargeForm": {
      "type": "object",
      "properties": {
        "mobilenumber": {
          "type": "string"
        },
        "rechargeamount": {
          "type": "string"
        }
      },
      "title": "MobileRechargeForm"
    },
    "SignupRequest": {
      "type": "object",
      "properties": {
        "email": {
          "type": "string"
        },
        "password": {
          "type": "string"
        },
        "role": {
          "type": "array",
          "uniqueItems": true,
          "items": {
            "type": "string"
          }
        },
        "username": {
          "type": "string"
        }
      },
      "title": "SignupRequest"
    },
    "WalletPaymentDto": {
      "type": "object",
      "properties": {
        "amount": {
          "type": "number",
          "format": "float"
        },
        "creditcard": {
          "$ref": "#/definitions/CreditCardDto"
        }
      },
      "title": "WalletPaymentDto"
    }
  }
}
```

