<#import "parts/common.ftlh" as c>
<#import "parts/loginCommon.ftlh" as l>

<@c.page>
    Login page
    <@l.loginCommon "/login" />
    <a href="/registration">Add new user</a>
</@c.page>