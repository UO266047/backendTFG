package com.uniovi.integracion.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_PortalSolicitudes {
    public static void addSolicitud(WebDriver driver, String diaSolicitarp, String diaCubrirp, String motivop) {

        driver.findElement(By.id("btnNuevaSolI")).click();

        WebElement dialog = driver.findElement(
                By.className("nueva-solicitud"));

        WebElement diaSolicitar = dialog.findElement(By.name("diaSolicitar"));
        diaSolicitar.click();
        diaSolicitar.clear();
        diaSolicitar.sendKeys(diaSolicitarp);

        WebElement diaCubrir = dialog.findElement(By.name("diaCubrir"));
        diaCubrir.click();
        diaCubrir.clear();
        diaCubrir.sendKeys(diaCubrirp);

        dialog.findElement(By.id("selectMotivo")).click();
        List<WebElement> options = dialog.findElements(By.xpath("//mat-option[@id='motivo']"));

        for (WebElement option : options) {
            if (option.getText().contains(motivop)) {
                option.click();
                break;
            }
        }

        dialog.findElement(By.id("solIntercambioBtn")).click();
    }

    public static void consultarMisSolicitudes(WebDriver driver, String diaCubrir, String diaSolicitar, String estado) {

        driver.findElement(By.cssSelector("div[id='mat-tab-label-0-1")).click();

        PO_View.checkElement(driver, "free", "//td[contains(text(), '" + diaCubrir + "')]" +
                "/following-sibling::*[contains(text(), '" + diaSolicitar + "')]" +
                "/following-sibling::*[contains(text(), '" + estado + "')]");
    }

    public static void consultarVacaciones(WebDriver driver, String periodoI, String periodoV, String estado) {

        driver.findElement(By.cssSelector("div[id='mat-tab-label-0-2")).click();

        PO_View.checkElement(driver, "free", "//td[contains(text(), '" + periodoI + "')]" +
                "/following-sibling::*[contains(text(), '" + estado + "')]");

        PO_View.checkElement(driver, "free", "//td[contains(text(), '" + periodoV + "')]" +
                "/following-sibling::*[contains(text(), '" + estado + "')]");
    }
}
