package ru.ibs.selenium.training.pages;

public class MegaPage {


    //3. Открыть меню "Каталог"
    ////button/span[text()='Каталог']

    //   4. Выбрать раздел "Комплектующие для ПК"
    ////div[text()='Комплектующие для ПК']/..
    //  5. Выбрать раздел "Видеокарты"
    ////span[text()='Видеокарты']/..    //p[contains(@class, 'CardCategory') and text()='Видеокарты']


    // Задать параметр поиска по цене от 20000 рублей
    //(//div[contains(@class,'RangeSelector_inputs')]/input[@name = 'min'])[1]

    // Выбрать производителя Gigabyte
    ////label[text()='Gigabyte']


    //8. Дождаться выполнения поиска
    ////div[text()='Товаров на странице: ']/span


    //10. Сохранить наименование первого товара в списке
    //(//div[contains(@class,'CardText_wrap')])[1]//div


    //11. В поисковую строку ввести запомненное значение, выполнить поиск
    ////div[contains(@class,'inputWrap SearchInput_input')]//input[@id='searchInput']


    //12. Проверить, что в поисковой выдаче не более 1 товара
    ////div[contains(@class,'Search_popularCards')]/div[contains(@class, 'CardSearch_wrap')]

    ////div[contains(@class,'Search_popularCards')]/div[contains(@class, 'CardSearch_wrap')]//div[contains(@class, 'CardText_title')]


//13. Проверить, что наименование товара соответствует сохраненному значению

}
