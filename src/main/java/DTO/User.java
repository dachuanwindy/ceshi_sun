package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/26 19:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    int age;
}
