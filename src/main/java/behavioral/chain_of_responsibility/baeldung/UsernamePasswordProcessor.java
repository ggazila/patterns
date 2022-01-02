package behavioral.chain_of_responsibility.baeldung;

public class UsernamePasswordProcessor extends AuthenticationProcessor {

    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthenticated(AuthenticationProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return true;
        } else if (next != null) {
            return next.isAuthenticated(authProvider);
        }
        return false;
    }
}
