<#import "parts/common.ftlh" as C>
<@C.page>
User editor

    <#if errorMessage??>
        <br>${errorMessage}</br>
        <form action="/admin/user" method="post">
            <input type="text" name="username" required="required" value="${user.username}">
            <input type="text" name="password" required="required" placeholder="new password">
            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
            <input type="hidden" value="${user.id}" name="userId">
            <#--    <input type="hidden" value="${_csrf.token}" name="_csrf">-->
            <button type="submit">Save</button>
        </form>
    <#else>
        <form action="/admin/user" method="post">
            <input type="text" name="username" required="required" value="${user.username}">
            <input type="text" name="password" required="required" placeholder="new password">
            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
            <input type="hidden" value="${user.id}" name="userId">
            <#--    <input type="hidden" value="${_csrf.token}" name="_csrf">-->
            <button type="submit">Save</button>
        </form>
    </#if>
</@C.page>