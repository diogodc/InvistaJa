<div class="home-title blue-gradient">Simple Task Board</div>

<div id="menu">
    <?php if($view == 'dashboard') { ?>
    <!-- Dashboard menu -->
    <?php echo anchor('user', 'Edit Users', 'class="btn btn_users"'); ?>
    <?php } elseif($view == 'users') { ?>
    <!-- Users menu -->
    <?php echo anchor('dashboard', 'Dashboard', 'class="btn btn_dashboard"'); ?>
    <?php echo anchor('user/add', 'Add new user', 'class="btn btn_add"'); ?>
    <?php } ?>
    <?php echo anchor('login/logout', 'Logout', 'class="btn btn_logout"'); ?>
    <div class="clear"></div>
</div>
<div id="page-title">
    <?php echo $page_title; ?>
</div>