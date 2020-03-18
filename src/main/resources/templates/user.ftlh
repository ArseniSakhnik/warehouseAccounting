<#import "parts/common.ftlh" as C>
<#import "parts/loginCommon.ftlh" as L>

<@C.page>
    <@L.logout/>
    <div>
    <table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Roles</th>
    </thead>

    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/admin/user/${user.id}">edit</a></td>
        </tr>
    </#list>
    </table>
    </div>

</@C.page>