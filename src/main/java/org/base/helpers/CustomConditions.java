package org.base.helpers;

import com.codeborne.selenide.*;

public class CustomConditions {
    public static WebElementCondition inputCondition = Condition.and("input condition", Condition.empty, Condition.visible);
}
