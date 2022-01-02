package behavioral.chain_of_responsibility.baeldung;

public abstract class AuthenticationProcessor {
    public AuthenticationProcessor next;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.next = nextProcessor;
    }

    public abstract boolean isAuthenticated(AuthenticationProvider authProvider);
}
