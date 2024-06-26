# language: ru

@all
Функция: Создание командировки

  @tripTest
  Сценарий: Невозможность создания командировки при незаполненных сотрудниках
    * Авторизация на странице корпоративного портала со стандартным паролем
    * Выбор меню создать командировку
    * Оформение командировки с стандартными тестовыми данными:
      | Department    | Отдел внутренней разработки |
      | CompanyName   | ОАО РОГА И КОПЫТА           |
      | TripTransport | Метро                       |
      | TripClass     | Маркетинговая               |
      | ArrivalCity   | Россия, Магадан             |
      | DepartureDate | 26                          |
      | ReturnDate    | 27                          |
    * Проверка ошибки на экране