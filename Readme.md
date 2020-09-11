# Simple Shop API
## <a name=""></a>Running the project
*Clone the project and run it on your IDE

*clone the project -> navigate to the folder -> open cmd -> run ./mvnw spring-boot:run


## <a name="using-application"></a>Using the application
Create order:

       http POST http://localhost:8080/api/orders/
 

Body
```json
{
    "order_line_set": [
        {
            "item": {
                "id":1
            },
            "quantity": 2
        },
        {
            "item": {
                "id":2
            },
            "quantity": 3
        }
    ]
} 
   
```
Get Items and their quantity:

      http Get http://localhost:8080/api/items
  




If you have any comment or any question please let me know!


Thank you!
