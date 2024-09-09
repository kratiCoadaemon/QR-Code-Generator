# QR Code Generator

## Description
This project is a QR Code Generator built using Java and Spring Boot. It allows users to generate QR codes for given text and file types.

## Installation
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2. Navigate to the project directory:
    ```bash
    cd qr-code-generator
    ```
3. Build the project using Gradle:
    ```bash
    ./gradlew build
    ```

## Usage
1. Run the application:
    ```bash
    ./gradlew bootRun
    ```
2. Open your browser and navigate to `http://localhost:8080`.
3. Use the provided HTML form to generate QR codes by entering the text and selecting the file type.

## API Endpoints
- `GET /api/v1/qrcode/generateQRCode` - Generates a QR code for the given text and file type.

## License
This project is licensed under the MIT License.