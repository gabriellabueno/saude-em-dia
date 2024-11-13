package br.edu.fatec.diariosaude.util;

public enum AtividadeFisica {

    IDOSOS("Exercícios aeróbicos de intensidade moderada a vigorosa por 2 a 5 horas semanais, com atividades de fortalecimento muscular e que enfatizem o equilíbrio, coordenação e treinamento de força, a fim de aumentar capacidade funcional e prevenir quedas. Realizar estes exercícios três ou mais dias por semana, ajustando ao nível de aptidão."),
    ADULTOS("Exercícios aeróbicos de intensidade moderada a vigorosa de 2 a 5 horas semanais ou entre 1 a 2 horas e meia de intensidade vigorosa, com atividades de fortalecimento muscular dois ou mais dias por semana."),
    GRAVIDA("Exercícios aeróbicos de intensidade moderada pelo menos 2 horas e meia por semana, incluindo atividades de fortalecimento muscular e alongamentos leves. \n Mulheres que antes da gravidez eram fisicamente ativas, podem continuar essas atividades durante a gravidez e no pós-parto. Evitar atividades que envolvam contato físico ou que possam limitar a oxigenação, sempre consultar um profissional de saúde antes de realizar atividades físicas."),
    SEDENTARIO("Começar com atividades leves, como caminhadas diárias, e progressivamente aumentar a intensidade e duração. Incorpore alongamentos diários para melhorar a flexibilidade e prevenir lesões. Dedique 5-10 minutos por dia a alongar os principais grupos musculares. \n Você pode utilizar o peso do corpo, como agachamentos, flexões de parede e levantamentos de pernas, para fortalecer os músculos sem a necessidade de equipamentos pesados.");

    private final String sugestao;

    AtividadeFisica(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getSugestao() {
        return sugestao;
    }


}
