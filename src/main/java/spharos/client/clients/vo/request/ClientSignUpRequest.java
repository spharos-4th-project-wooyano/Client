package spharos.client.clients.vo.request;


import lombok.Getter;

@Getter
public class ClientSignUpRequest {

    private String email;
    private String password;
    private String ceoName;
    private String clientName;
    private String clientPhone;
    private String clientAddress;
    private String clientRegistrationNumber;
    private String clientRegistrationImgUrl;
    private String bankName;
    private String bankAccount;
    private String bankHolder;
    private String bankImgUrl;

}
