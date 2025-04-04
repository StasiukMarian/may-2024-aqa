package org.base.pojos.updateUser;

import lombok.Data;
import org.base.pojos.createUser.CreateUserRequest;

@Data
public class UpdateUserResponse extends CreateUserRequest {
    private String updatedAt;
}
