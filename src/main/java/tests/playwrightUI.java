package tests;

import configurations.BaseTest;
import configurations.BaseUri;
import dataProviders.Navbar;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

class PlaywrightUI extends BaseTest {

    @Test
    public void shouldClickButton() {
        navigateTest(BaseUri.playwrightUrl());
        Navbar navbar = new Navbar(page);
        navbar.clickToggleButton();
    }

    @Test
    public void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        Boolean checked = (Boolean) page.evaluate("() => document.getElementById('checkbox').checked");
        assertTrue(checked);
    }

    @Test
    public void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        page.locator("input[name=search]").click();
        page.locator("input[name=search]").fill("playwright");
        page.locator("input[name=search]").press("Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }
}
