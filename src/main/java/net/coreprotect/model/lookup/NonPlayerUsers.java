package net.coreprotect.model.lookup;

/**
 * Marker for "every non-player user" in an excluded-user list.
 * <p>
 * Non-player users (#hopper, #tnt, #fire, names logged through the API, ...) are
 * the user rows with no UUID. The marker is resolved to their IDs when the
 * lookup query is built.
 */
public final class NonPlayerUsers {

    /**
     * Excluded-user token for all non-player users, as typed in {@code e:#*}.
     */
    public static final String TOKEN = "#*";

    private NonPlayerUsers() {
        throw new IllegalStateException("Model class");
    }

    public static boolean isToken(String user) {
        return TOKEN.equals(user);
    }
}
