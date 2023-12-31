package spharos.client.service.domain.category.enumType;

import lombok.Getter;
import spharos.client.global.common.domain.BaseEnum;

@Getter
//Category테이블 중분류 필드 생성을 위한 enum클래스
public enum ServiceBaseCategoryType implements BaseEnum<String, String>{

//    NOT_APPLICABLE(0,"NOT_APPLICABLE"),
//    ↑ 0 번은 해당하는 경우가 없는거 같아서 주석처리하였습니다.

    HOUSE_KEEPER("1","HOUSE_KEEPER"),
    MOVING("2","MOVING_CLEAN"),
    OFFICE("3","OFFICE_CLEAN"),
    ELECTRONICS("4","ELECTRONICS_CLEAN");

    private final String key;
    private final String value;

    ServiceBaseCategoryType(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
