import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PeerRegistration {
    private Map<String, KeyPair> keyPairs = new HashMap<>();

    public void registerPeer(String peerId) throws NoSuchAlgorithmException {
        // Generate public and private key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        
        // Store the key pair for the peer
        keyPairs.put(peerId, keyPair);
        
        // Publish files to the master server
        publishFiles(peerId);
    }
    
    private void publishFiles(String peerId) {
        // Code to publish files to master server
    }
    
    // Getter method to retrieve the public key for a peer
    public String getPublicKey(String peerId) {
        return keyPairs.get(peerId).getPublic().toString();
    }
}
