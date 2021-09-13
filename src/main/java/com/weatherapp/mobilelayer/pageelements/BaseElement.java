package com.weatherapp.mobilelayer.pageelements;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.weatherapp.mobilelayer.logger.Logger;

public class BaseElement extends WrappedMobileElement {

    protected BaseElement(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        try {
            Logger.info("Click on the btn");

            getWrappedElement().click();
        } catch (NoSuchElementException ex) {
            Logger.error(ex.getMessage());
//            throw new ElementNotFoundException(getWrappedElement());
        }
    }
}
