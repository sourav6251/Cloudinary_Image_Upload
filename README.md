Here's a README file that follows the steps outlined in the previous guide for setting up and testing your image upload API.

---

# Image Upload API with User Information

This project provides a REST API for uploading images along with user information. The user provides data such as `userId`, `name`, `password`, and `email`, while also uploading an image. The server processes the image upload and returns both the uploaded image's URL and the user information.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [API Endpoints](#api-endpoints)
    - [POST /upload](#post-upload)
- [Testing the API](#testing-the-api)
    - [Testing with `curl`](#testing-with-curl)
    - [Testing with Postman](#testing-with-postman)

---

## Prerequisites
- **Java**: 11 or higher
- **Spring Boot**: 2.x or higher
- **Maven**: 3.x or higher
- **Cloudinary (or any image storage service)** for storing images (used in this example)
- **Postman** or **curl** for testing the API.

---

## Project Setup

1. Clone the repository.
2. Navigate to the project directory:
   ```bash
   cd image-upload-api
   ```
3. Install dependencies (if using Maven):
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The server will start on `http://localhost:8080`.

---

## API Endpoints

### POST `/upload`

This endpoint allows the upload of both an image and user information.

#### Request Format
- **Content-Type**: `multipart/form-data`
- **Parameters**:
    - `file` (required): The image file to upload.
    - `userdata` (required): JSON data containing user information.

#### Example Request (via `curl`):
```bash
curl -X POST "http://localhost:8080/upload" \
     -H "Content-Type: multipart/form-data" \
     -F "file=@/path/to/your/image.png" \
     -F "userdata={\"userId\":\"098765\",\"name\":\"sourav\",\"password\":\"securePass\",\"email\":\"johndoe@example.com\"};type=application/json"
```

#### Example Request (via Postman):
1. **Method**: `POST`
2. **URL**: `http://localhost:8080/upload`
3. **Body Type**: `form-data`
4. **Form Data**:
    - **Key**: `file` → Choose an image file to upload.
    - **Key**: `userdata` → Paste the following JSON in the **Text** field:
      ```json
      {
        "userId": "098765",
        "name": "sourav",
        "password": "securePass",
        "email": "johndoe@example.com"
      }
      ```
    - Set the **Content-Type** header to `multipart/form-data`.

#### Response Format
- **Status**: `200 OK`
- **Body**:
  ```json
  {
    "userId": "098765",
    "name": "sourav",
    "password": "securePass",
    "email": "johndoe@example.com",
    "imageURL": "http://res.cloudinary.com/your-image-url",
    "publicId": "your-image-public-id"
  }
  ```

---

## Testing the API

### Testing with `curl`
To test the API using `curl`:

1. Open a terminal.
2. Use the following command to send a request with a file and user data:
   ```bash
   curl -X POST "http://localhost:8080/upload" \
        -H "Content-Type: multipart/form-data" \
        -F "file=@/path/to/your/image.png" \
        -F "userdata={\"userId\":\"12345\",\"name\":\"Sourav\",\"password\":\"securePass\",\"email\":\"sourav@example.com\"};type=application/json"
   ```

### Testing with Postman
1. **Method**: `POST`
2. **URL**: `http://localhost:8080/upload`
3. **Body**: Select `form-data`
4. **Key-Value Pairs**:
    - **Key**: `file` → Choose an image file to upload (set type to `File`).
    - **Key**: `userdata` → Paste the following JSON:
      ```json
      {
        "userId": "098765",
        "name": "Sourav",
        "password": "securePass",
        "email": "sourav@example.com"
      }
      ```
      Set the **Content-Type** header to `multipart/form-data`.

5. Click **Send** to make the request.

---

## Troubleshooting

- **Error: 415 Unsupported Media Type**: This usually happens if the request does not have the correct `Content-Type`. Ensure that you're using `multipart/form-data` and sending the image and JSON as separate parts.

- **UserInfo fields are null**: Ensure you use `@RequestPart` for handling JSON payloads in combination with file uploads, as described above.

---

## Conclusion
With this API, you can upload both images and user data in a single request, making it easier to manage media uploads along with user-related information. You can test the API using `curl` or Postman, and the server responds with both the user info and the uploaded image's URL.

