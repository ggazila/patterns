package behavioral.chain_of_responsibility.baeldung;

public class OAuthProcessor extends AuthenticationProcessor {
    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthenticated(AuthenticationProvider authProvider) {
        if (authProvider instanceof OAuthTokenProvider) {
            return true;
        } else if (next != null) {
            return next.isAuthenticated(authProvider);
        }

        return false;
    }
}
