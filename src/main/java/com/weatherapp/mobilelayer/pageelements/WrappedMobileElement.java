package com.weatherapp.mobilelayer.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class WrappedMobileElement implements WrapsElement {

    private final WebElement wrappedElement;

    protected WrappedMobileElement(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public WebElement getWrappedElement() {
        return wrappedElement;
    }
}
