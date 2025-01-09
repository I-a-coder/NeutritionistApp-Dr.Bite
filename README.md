# Dr. Bite App

## Overview
The Dr. Bite App is a health and wellness mobile application designed to help users track their daily caloric intake by logging food items, viewing progress, and managing their diet plans. The app utilizes Firebase Authentication for secure user sign-ins and registrations, allowing users to access personalized data. The core functionality revolves around tracking food intake, calculating total calories, and monitoring progress toward a daily caloric goal.

## Features and Functionality

### User Authentication
- **SignUpActivity**: Users can create a new account by entering their email address and password. The system ensures that the passwords match before proceeding.
- **SignInActivity**: After signing up, users can sign in with their credentials (email and password) to access their profile and track their progress.
- Firebase Authentication is used to manage user authentication, ensuring secure sign-in and sign-up processes.

### Data Logging (Food Tracking)
- **DataActivity**: In this screen, users can log the food items they consume during the day. The user can enter a food item (e.g., "Apple", "Banana") into a text field.
- The app retrieves the corresponding calorie information from a predefined list of food items stored in a HashMap.
- Users can click the plus button to add the item to their log. Each food item is then stored along with its calorie count.
- Users can remove the last logged food item using the minus button.
- A running total of the calories consumed is calculated and updated dynamically as items are added or removed.

### Progress Monitoring
- **ProgressActivity**: Once food items are logged, users can view their daily progress.
- The app calculates the remaining calories to reach the user's target daily caloric intake.
- It displays:
  - The required caloric intake (set by the user).
  - The total calories consumed from logged food items.
  - The remaining calories to meet the target.
- This helps users track how close they are to their dietary goals and make informed decisions about their next meal.

### Navigation
- After logging food data, users can navigate seamlessly from the DataActivity to ProgressActivity to view their progress.
- The SignInActivity and SignUpActivity are linked, allowing users to easily transition from registration to sign-in.

## New and Unique Features

### Predefined Calorie Database
The app comes with a predefined list of food items and their respective calories stored in a HashMap. This allows users to quickly add common foods to their log without needing to manually input nutritional information each time. Example items include:
- Apple: 95 kcal
- Banana: 105 kcal
- Pizza: 285 kcal

### Dynamic Calorie Tracking
The app tracks total calories consumed in real time as users log food items. It calculates the remaining calories the user can consume for the day based on their set daily goal. This dynamic feature ensures users can make adjustments to their food intake on the go, enhancing their dietary control and health management.

### User-Friendly Data Removal
The app features a minus button that allows users to easily remove the last logged food item. This feature helps users make quick corrections to their food log without manually clearing all data, improving usability and flexibility.

### Seamless User Experience
The app utilizes a smooth transition between screens (Sign Up, Sign In, Data Entry, and Progress View) with simple buttons, providing users with an intuitive and easy-to-navigate interface. Firebase Authentication ensures security and privacy for users' accounts and personal data.

## Future Enhancements
- **Extended Food Database**: The app can be extended to include a larger, more comprehensive food database, possibly with integration to an external API for detailed food nutrition data.
- **User -Set Daily Caloric Goal**: A future version could allow users to set their personalized daily caloric intake based on their age, weight, height, and activity level, providing a more tailored dietary plan.
- **Activity and Exercise Integration**: The app could include functionality for users to log physical activities and calculate how many calories they burn, allowing for a more holistic approach to health and fitness.
- **Data Persistence**: The app could integrate persistent storage, so users' food logs and progress data are saved even when they log out or close the app, improving the overall experience.

## Conclusion
The Dr. Bite App is a straightforward yet powerful tool for anyone looking to manage their calorie intake and monitor their daily nutritional progress. With features like predefined food calorie data, real-time tracking, and dynamic progress updates, it offers a user-friendly and effective approach to maintaining a healthy diet.
