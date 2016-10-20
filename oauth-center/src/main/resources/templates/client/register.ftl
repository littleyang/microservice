<#include "../layout/head.ftl"/>
<h1> this is oauth client register page</h1>
<button id="create_client" type="button" class="btn btn-success"><a href="/open/patrner/clients">首页</a></button>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="input-client-id" class="col-sm-2 control-label">client id</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="input-client-id" placeholder="client id">
        </div>
    </div>
    <div class="form-group">
        <label for="input-client-secret" class="col-sm-2 control-label">client secret</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="input-client-secret" placeholder="client secret">
        </div>
    </div>
    <div class="form-group">
        <label for="input-client-redirect-url" class="col-sm-2 control-label">回调URL地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="input-client-redirect-url" placeholder="url">
        </div>
    </div>
    <div class="form-group">
        <label for="input-client-secret" class="col-sm-2 control-label">认证类型</label>
        <div class="col-sm-10">
            <div class="checkbox">
                <label class="checkbox-inline">
                    <input type="checkbox" id="authorization-code-box" value="authorization_code"> authorization_code
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="password-box" value="password"> password
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="client-credentials-box" value="client_credentials"> client_credentials
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="refresh-token-box" value="refresh_token"> refresh_token
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>

<#include "../layout/foot.ftl"/>