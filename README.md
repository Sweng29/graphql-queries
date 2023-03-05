# graphql-queries
GraphQL Example

Go to spring initilizer and add GraphQL dependency in your project, once project imported,

# Step 1: Add a new folder named as graphql and create a file with .graphqls or .gqls extension and add following text,

# Root Query is always required
type Query{
    greeting: String
    greetingWithArgument(name : String): String
    recentPosts: [Post]!
}

# ! means non nullable

type Post {
    id: ID!
    title: String!
    text: String!
    category: String
    author: Author!
    comments: [Comment]
}

type Author {
    id: ID!
    name: String!
    thumbnail: String
    posts: [Post]!
}

# for batch operations to handle n+1 case calls

type Comment {
    id: ID,
    text: String
    likes: ID
    dislikes: ID
    shareUrl: String
    post: Post
}

type Mutation{
    addPost(title: String, text: String, category: String): Post
}

# Step 02: Add spring.graphql.graphiql.enabled=true in properties file to load enable graphiql for queries

# Step 03: Goto: http://localhost:8080/graphiql?path=/graphql and paste following query in editor,


query{
  recentPosts{
    id,
    title,
    text
    category,
    comments{
      id
      text
      likes
      dislikes
      shareUrl
    }
  }
}

Responses:


<img width="1566" alt="Screenshot 2023-03-05 at 10 46 10 PM" src="https://user-images.githubusercontent.com/39361182/222980303-0376a751-eaff-443d-b1c2-308144a3024f.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 46 32 PM" src="https://user-images.githubusercontent.com/39361182/222980404-a626282f-be61-4b17-922c-1e4648b976d3.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 47 36 PM" src="https://user-images.githubusercontent.com/39361182/222980410-3c40e095-bf73-4154-8631-b514f86ab460.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 51 24 PM" src="https://user-images.githubusercontent.com/39361182/222980418-7c9cf274-8c9f-4a79-beb1-39c58e7862ed.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 51 41 PM" src="https://user-images.githubusercontent.com/39361182/222980419-58e7bab8-4a97-47c7-a56f-cfa20dcd0770.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 53 40 PM" src="https://user-images.githubusercontent.com/39361182/222980424-d2abff14-26e0-4e84-b902-039c6dbb3f93.png">

<img width="1610" alt="Screenshot 2023-03-05 at 10 53 49 PM" src="https://user-images.githubusercontent.com/39361182/222980432-065ee5dc-b1db-4fa0-9a09-cb567a701cd3.png">

# @BatchMapping - When you want to handle N+1 case, in this case a post can have thousands of comments to reduce network call we'll use batch mapping

<img width="1610" alt="Screenshot 2023-03-05 at 11 52 42 PM" src="https://user-images.githubusercontent.com/39361182/222982700-b39bdb19-3d6b-4a08-a6b8-866e559631ab.png">

<img width="1610" alt="Screenshot 2023-03-05 at 11 53 11 PM" src="https://user-images.githubusercontent.com/39361182/222982704-8d35b332-4037-47ab-b051-1e2f4803e064.png">

<img width="1610" alt="Screenshot 2023-03-05 at 11 53 22 PM" src="https://user-images.githubusercontent.com/39361182/222982714-c073ec2c-455c-4331-959a-7bd1efbea9b3.png">

<img width="1610" alt="Screenshot 2023-03-05 at 11 53 35 PM" src="https://user-images.githubusercontent.com/39361182/222982723-4fcd6718-b431-4199-85dd-b62b859f09a2.png">

# @MutationMapping - When you want to add/modify data using GraphQL - following will add a new post with title, text and category argument and will return newly created post with provided fields as given inside curly brackets,

mutation{
  addPost(title:"Angular", 
    text:"Hello Angular", 
    category: "UI Framework"){
	  id
    title
    text
    category
    comments{
      id
      text
      likes
      dislikes
      shareUrl
    }
  }
}

Responses:

<img width="1610" alt="Screenshot 2023-03-06 at 12 35 47 AM" src="https://user-images.githubusercontent.com/39361182/222984678-c25c7d27-df7a-4a29-9b84-63eba3ce5384.png">

<img width="1610" alt="Screenshot 2023-03-06 at 12 37 07 AM" src="https://user-images.githubusercontent.com/39361182/222984689-048e3d41-32b1-4b07-8679-2e2bb19f4b74.png">

# Fetch data after adding

query{
  recentPosts{
    id,
    title,
    text
    category,
    comments{
      id
      text
      likes
      dislikes
      shareUrl
    }
  }
}


<img width="1610" alt="Screenshot 2023-03-06 at 12 37 45 AM" src="https://user-images.githubusercontent.com/39361182/222984701-0d0d5bd8-c421-4ac4-a671-2b62ac06594b.png">





