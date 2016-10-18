<#include "../layout/head.ftl"/>
<h1> this is oauth clients</h1>
<button id="create_client" type="button" class="btn btn-success"><a href="/open/patrner/client/register">新建Client</a></button>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>Client Id</th>
            <th>Client Secret</th>
            <th>scope</th>
            <th>grant types</th>
            <th>redirect Url</th>
            <th>Create Time</th>
        </tr>
    </thead>
    <tbody>
        <#list clients as client>
        <tr>
            <td>${client.clientId}</td>
            <td>${client.clientSecret}</td>
            <td>${client.scope}</td>
            <td>${client.authorizedGrantTypes}</td>
            <td>${client.webServerRedirectUri}</td>
            <td>${client.createTime}</td>
        </tr>
        </#list>
    </tbody>
</table>
<#include "../layout/foot.ftl"/>