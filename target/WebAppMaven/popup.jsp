<%@ page contentType="text/html; charset=UTF-8" %>
<div id="popUp">
    <div id="popup_close">
        <img class="popup_cross" src="img/close.png" alt="Close"/>
    </div>
    <h2 id="popup_header">Order:</h2>
    <div id="popup_innerContainer">
        <select id="popup_role" name="role" form="popup_form">
            <option value="" selected="selected" disabled="disabled" >Välj behörighet:</option>
            <option value="ROLE_ADMIN">Administratör</option>
            <option value="ROLE_USER">Användare</option>
        </select>
        <br>
        <form id="popup_form">
            <input id="popup_id" type="hidden" name="id"/>
            <input id="popup_name" type="text" name="name" placeholder="Nytt namn"/>
            <input id="popup_email" type="text" name="email" placeholder="Ny mail adress"/>
            <input id="popup_password" type="text" name="password" placeholder="Nytt lösenord"/>
            <br>
            <button id="popup_submit" formmethod="post" formaction="UpdateServlet">Ok</button>
            <button id="popup_delete" formmethod="post" formaction="DeleteServlet">Radera</button>
        </form>
    </div>
</div>
