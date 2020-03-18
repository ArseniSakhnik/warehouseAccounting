<#import "parts/common.ftlh" as C>
<#import "parts/loginCommon.ftlh" as L>

<@C.page>
    <@L.logout/>

        Category list

            <#if categoryList??>
                <br>Категории ещё не добавлены</br>
                <br><a href = "/category/addCategory">Добавить категорию</a> </br>
            <#else>
                <#list categoryList as category>
                    <div>
                    <table>
                    <thead>
                    <th>Название</th>
                    <th>Количество товара</th>
                    <th>Описание</th>
                    </thead>
                    <td>${category.categoryName}</td>
                    <td>${category.products?size}</td>
                    <td>${category.categoryDescription?substring(0, 150)}</td>
                    <td><a href="/edit/${category.categoryName}">Edit</a></td>
                    <td><a href="/${category.categoryName}">Delete</a></td>
                </#list>
            </#if>

        </table>
    </div>

</@C.page>