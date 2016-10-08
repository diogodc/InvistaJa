<?php
defined('BASEPATH') OR exit('No direct script access allowed');?>
<?php  $this->load->view('head');?>
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="<?php echo base_url("assets/img/profile.png") ?>" alt="">
                    <div class="intro-text">
                        <span class="name">Quero ficar rico!!</span>
                        <hr class="star-light">
                        <span class="skills">O Invista Já vai te ajudar a melhorar de vida</span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Aprenda a Investir</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/cabin.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/cake.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/circus.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/game.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/safe.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<?php echo base_url("assets/img/portfolio/submarine.png") ?>" class="img-responsive" alt="">
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>De Onde Viemos</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-lg-offset-2">
                    <p>Somos uma equipe de estudantes da Faculdade UCL e desenvolvemos esse projeto para atender a necessidade de uma parte da população com pouco acesso a informações sobre finanças.</p>
                </div>
                <div class="col-lg-4">
                    <p>Estamos buscando levar a sustentabilidade social a um sistema que não favorece a todos, e tentando gerar informação confiável e que gere conhecimento.</p>
                </div>
            </div>
        </div>
    </section>

    <?php  $this->load->view('footer');?>
   
    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>
                        
                        

    <!-- Portfolio Modals -->
    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Aprendendo a Investir</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/cabin.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Uma pessoa de bom senso deve simplesmente ignorar "dicas" para ficar rico da noite para o dia. Definitivamente as probabilidades estão contra você, quando se trata de ganhar uma bolada ou herdar uma fortuna.</p>
                            <p>No entanto, a boa notícia é que você pode construir um patrimônio mesmo assim. Para tanto é necessário ter um plano de investimento.</p> 
                            <p>Investimento não é jogo. Jogo é para especuladores que "apostam" todas as suas "fichas" numa única "dica" e ficam torcendo dia e noite pelo resultado de suas apostas.
                            Tudo o que você não precisa para ter sucesso em seus investimentos são apostas, fichas e dicas. Num processo de investimento não há apostas e nem fichas e dicas, mas sim objetivos e a melhor carteira (alocação de ativos) para conquistá-los. Afinal, investimento bem-sucedido é aquele que vai fazer com que você conquiste seus objetivos.</p>
                            <p>Não existe o melhor investimento, mas sim o investimento mais adequado para você atingir seus objetivos.</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Organize sua Contas</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/cake.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Um orçamento mostrará qual a sua situação financeira atual, se suas despesas cabem no seu salário. Ele é a fotografia de suas despesas e receitas.</p>
                            <p>Se o que você ganha não cobre suas despesas mensais sua situação já é bastante perigosa, principalmente num país como o Brasil, onde as taxas de juro estão muito altas. Comece a fazer já o seu orçamento e convoque a família porque os cortes precisam ser feitos em conjunto.</p>
                            <p>Se seu salário cobre suas despesas, mas não há sobras, você pode ter problemas. Por isso, chame sua família para uma conversa e mostre que, sem sobras no orçamento não será possível conquistar objetivos, como a viagem, a faculdade e até mesmo a casa própria. Juntos avaliem as despesas e vejam como podem cortar um pouco de cada item.</p>
                            <p>Se você está com folga no orçamento, parabéns! Você faz parte de um seleto grupo que já consegue ter sobras no fim do mês. No entanto avalie se</p>
                            <p>• ... você fez as contas corretamente;</p>
                            <p>• ... você não esqueceu de colocar nenhum item de despesa;,/p>
                            <p>• ... o que está sobrando é suficiente para conquistar seus objetivos.</p>
                            <h3>Dez razões para ter um orçamento:</h3>
                            <h5>1 Você saberá qual o real alcance de sua renda.</h5>
                            <h5>2 Evitará que você assuma dívidas que não poderá pagar.</h5>
                            <h5>3 Você conseguirá identificar e cortar desperdícios.</h5>
                            <h5>4 É o primeiro passo para construir um patrimônio.</h5>
                            <h5>5 Você não precisará ficar contando os dias para chegar o fim do mês.</h5>
                            <h5>6 Sua família enxergará para onde vai o seu salário.</h5>
                            <h5>7 Sua família saberá quais as demandas que cabem no orçamento.</h5>
                            <h5>8 Seu filho aprenderá com seu exemplo a ser um adulto financeiramente responsável.</h5>
                            <h5>9 Sua produtividade no trabalho tende a aumentar sem aflições financeiras.</h5>
                            <h5>10Você conseguirá criar um plano de investimento para manter seu padrão de vida durante sua aposentadoria.</h5>

                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/circus.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/game.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/safe.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img src="<?php echo base_url("assets/img/portfolio/submarine.png") ?>" class="img-responsive img-centered" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="<?php echo base_url("assets/vendor/jquery/jquery.min.js")?>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<?php echo base_url("assets/vendor/bootstrap/js/bootstrap.min.js")?>"></script>

    <!-- Plugin JavaScript -->
    <script src="<?php echo site_url("https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js") ?>"></script>

    <!-- Contact Form JavaScript -->
    <script src="<?php echo base_url("assets/js/jqBootstrapValidation.js")?>"></script>
    <script src="<?php echo base_url("assets/js/contact_me.js")?>"></script>

    <!-- Theme JavaScript -->
    <script src="<?php echo base_url("assets/js/freelancer.min.js")?>"></script>

</body>

</html>
