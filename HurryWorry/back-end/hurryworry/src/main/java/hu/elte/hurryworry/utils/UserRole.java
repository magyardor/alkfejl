package hu.elte.hurryworry.utils;

/**
 * The UserRole enumerator implements the available roles of the users in the
 * system.
 *
 * @author eksztazidzsi
 */
public enum UserRole {

    /**
     * The role of the system administrators.
     */
    ADMINISTRATOR,

    /**
     * The role of guest users without registration.
     */
    GUEST,

    /**
     * The role of the average users.
     */
    USER,

    /**
     * THIS ROLE IS FOR TESTING ONLY.
     */
    TEST
}
