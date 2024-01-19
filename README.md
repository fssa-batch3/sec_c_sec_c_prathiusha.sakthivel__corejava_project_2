DB TABLE

| Column Name         | Data Type         | Constraints             |
|---------------------|-------------------|-------------------------|
| ProductId           | SERIAL            | PRIMARY KEY             |
| ProductName         | VARCHAR(50)       |                         |
| ProductImageUrl     | VARCHAR(200)      |                         |
| ProductPrice        | double(10, 2)     | CHECK (>= 10)           |
| ProductQuantity     | double(10, 2)     | CHECK (>= 0)            |
| ProductPercentage   | INT               | CHECK (>= 0 AND <= 100) |
| ProductDescription  | VARCHAR(800)      |                         |
| ProductCategory     | VARCHAR(10)       |                         |
| ProductCreateddate  | DATE              | CHECK (<= CURRENT_DATE) |

