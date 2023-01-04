## Modelo

```mermaid
%%{init: {'theme': 'dark'}}%%
classDiagram
    User --> "0..*" User
    User "1" --> "0..*" Post
    Post "0..*" --> "1" PostCategory
    Post "0..*" --> "1" Product
    Product "0..*" --> "1" ProductType
    
    class User {
        -id : Integer
        -username : String
        -followers : List~User~
        -following : List~User~
        -posts : List~Post~
        +follow(user : User)
        +addFollower(user : User)
        +removeFollower(user : User)
        +removeFollowing(user : User)
        +addPost(post : Post)
    }
    
    class Post {
        -id : Integer
        -date : LocalDate
        -product : Product
        -postCategory : Category
        -price : double
        -hasPromo : boolean
        -discount : double
    }
    
    class PostCategory {
        -id : Integer
        -code : int
        -name : String
    }
    
    class Product {
        -id : Integer
        -name : String
        -type : ProductType
        -brand : String
        -color : String
        -notes : String
    }
    
    class ProductType {
        -id : Integer
        -name : String
        -description : String
    }
        
```