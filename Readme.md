# Simple Shop Api
## <a name="contributor"></a>Three ways to run the project
*Clone the project and run it on your IDE

*Use docker 

*clone the project -> navigate to the folder -> open cmd -> run ./mvnw spring-boot:run


## <a name="using-application"></a>Using the application
Create order:

       http POST http://localhost:8080/api/order/
 

Body
```json
{
"shippingAddress":{
       "street":"100 n4th street",
       "city":"fairfield",
       "state":"IA",
       "zipCode":"52557"
   },
   "billingAddress":{
       "street":"100 n4th street",
       "city":"fairfield",
       "state":"IA",
       "zipCode":"52557"
   },
"orderLines":[{
    "productId":2,
    "quantity":5
}]
}
```
Get Product with quantity:

      Http Get http://localhost:8080/api/product
  
## <a name="contributor"></a>About the Webservice

I used command query and hexagonal architecture to separate technology from business logic, to make the application loose-couple, extensible and testable.
I have Implemented Custom Exception, Custom Log format and Log level configuration.
I used Springdoc under open API Specification.
I wrote only one simple test Case because of the time limit.
I have also tried to write package level java documentation.



If you have any comment or any question please let me know!


## <a name="contributor"></a>Contributor

* [yome mengistu](https://www.linkedin.com/yome-mengistu)

Thank you!
