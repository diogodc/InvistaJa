var _router = bovespa.router;
_router.register([
    {
        name: 'bovespa-company',
        route: 'bovespa:EMPRESAS'
    }
]).register([
    {
        name: 'bovespa-home',
        route: 'bovespa:HOME'
    }
]).register([
    {
        name: 'bovespa-indebtedness',
        route: 'bovespa:ENDIVIDAMENTO'
    }
]).register([
    {
        name: 'bovespa-liquidity',
        route: 'bovespa:LIQUIDEZ'
    }
]);

