package flavorvault;

public class SessionManager {
    private static int currentUserId;
    private static String currentUsername; // Add a field for the username

    public static void setCurrentUserId(int userId) {
        currentUserId = userId;
    }

    public static int getCurrentUserId() {
        return currentUserId;
    }

    public static void setCurrentUsername(String username) { // Setter for username
        currentUsername = username;
    }

    public static String getCurrentUsername() { // Getter for username
        return currentUsername;
    }
}