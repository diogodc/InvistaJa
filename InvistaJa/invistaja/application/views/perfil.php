<?php
defined('BASEPATH') OR exit('No direct script access allowed');?>
<?php  $this->load->view('head');?>
<header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="<?php echo base_url("assets/img/perfil.png") ?>" alt="">
                    <div class="intro-text">
                        <span class="name">Saber seu perfil</span>
                        <hr class="star-light">
                        <span class="skills">É uma parte importante!</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
<!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Responda algumas perguntas:</h2>
                    <hr class="star-primary">
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    
                </div>
            </div>
        </div>
    </section>

<?php  $this->load->view('footer');?>