<#import "parts/common.ftlh" as C>
<#import "parts/loginCommon.ftlh" as L>


<@C.page>

    <@L.logout/>

    <div>
        <form method="post" enctype="multipart/form-data">
            <br><input type="file" name="file"/></br>
            <input type="text" name="categoryName" placeholder="Категория"/>
            <input type="text" name="productName" placeholder="Название"/>
            <textarea  name="productDescription" placeholder="Описание"></textarea>
            <input type="number" name="price" placeholder="Стоимость"/>
            <input type="number" name="quantity" placeholder="Количество"/>
            <input type="submit" value="Add"/>
        </form>

        <#list products as product>
            <div>Категория: ${product.category.categoryName}</br></div>
            Название продукта: ${product.productName}<br>
            Описание: ${product.productDescription}<br>
            Цена: ${product.price}<br>
            Количество: ${product.quantity}<br>
            <#if product.imageName??>
                <div>Изображение</div>
                <img src="/img/${product.imageName}"/>
            </#if>
        <#else>
            no image
            </div>
        </#list>

    </div>
</@C.page>