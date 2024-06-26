# language: ru

@all
Функция: Создание командировки

  @productTest
  Структура сценария: : Выбрать в каталоге товар определенной категории, выбрать первый в списке и найти его в поиске
    * Открытие основной страницы магазина и выбор каталога
    * Выбираем категорию: "<category>" и тип товара: "<cardCategory>"
    * Фильтруем по минимальной цене - "<minPrice>" и производителю - "<firm>"
    * Проверяем, что на странице отображается 24 позиции
    * Получить первый товар из списка и найти его по поиску

    Примеры:
      | category             | cardCategory | minPrice | firm     |
      | Комплектующие для ПК | Видеокарты   | 20000    | Gigabyte |
      | Периферия            | Клавиатуры   | 2000     | A4Tech   |