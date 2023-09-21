# Spaarks Foundation Android Developer Assignment

This Android project was created as a technical assignment for the Spaarks Foundation Android developer role. The project demonstrates the use of MVVM architecture, data binding, Retrofit, Java, Google Maps integration, and Preference DataStore.

## Getting Started

To run the project, follow the steps below:

1. Clone the GitHub repository to your local machine:
   
  ```
  git clone https://github.com/kartikeysaran/Spaarks_Assignment
  ```
2. Open the project in Android Studio.

3. In the `res/values/strings.xml` file, replace `[PASTE_API_KEY_HERE]` with your Google Maps API key. This is required for the Google Maps integration.

4. Build and run the project on an Android emulator or a physical device.

## Login Screen

Upon launching the app, users are initially directed to the login screen. The login screen allows users to enter a username and password. 

- If the user enters "123" as both the username and password, they are forwarded to the main screen.

- If the user enters an incorrect password, a toast message informs them that invalid credentials has been entered.

- Upon entering the correct username and password, the user's login state is saved in Preferences DataStore, and they do not need to log in again in future app sessions.

## Main Screen

The main screen consists of two components:

### 1. Maps Screen

- The Maps screen displays a Google Map with markers that pinpoint the location of a user.

### 2. RecyclerView

- Below the map, there is a RecyclerView that displays user details.

- Users can swipe items in the RecyclerView to delete them. When an item(user) is swiped, it is removed from the list, and the next item (user) location in the list is displayed on the map.

## Project Structure

The project follows the MVVM (Model-View-ViewModel) architecture pattern:

- `Model`: Contains the data classes and repository for handling data.
- `View`: Contains the XML layout files for the login screen and main screen.
- `ViewModel`: Contains the ViewModel classes that manage the UI logic and data for the login and main screens.

## Libraries and Technologies Used

- MVVM architecture
- Data Binding
- Retrofit for API communication
- Java programming language
- Google Maps API for location services
- Preference DataStore for storing login state

## Contact

For any questions or inquiries about this project, please contact:

- Kartikey Saran
- Email: sarankartikey@gmail.com

Thank you for reviewing this project!
