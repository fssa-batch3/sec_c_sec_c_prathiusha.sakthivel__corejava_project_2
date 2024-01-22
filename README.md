DB TABLE

| Product      | Data Type         | Constraints             |
|--------------|-------------------|-------------------------|
| Id           | SERIAL            | PRIMARY KEY             |
| Name         | VARCHAR(50)       |                         |
| ImageUrl     | VARCHAR(200)      |                         |
| Price        | double(10, 2)     | CHECK (>= 10)           |
| Quantity     | double(10, 2)     | CHECK (>= 0)            |
| Percentage   | INT               | CHECK (>= 0 AND <= 100) |
| Description  | VARCHAR(800)      |                         |
| Category     | VARCHAR(10)       |                         |
| Createddate  | DATE              | CHECK (<= CURRENT_DATE) |

