void main() {
    Scanner scanner = new Scanner(System.in);

    List<Pessoas> banco = new ArrayList<>();
    List<Pessoas> cache = new ArrayList<>();


    banco.add(new Pessoas(1, "kauã", 20));
    banco.add(new Pessoas(2, "Emerson", 22));
    banco.add(new Pessoas(3, "Victor", 17));
    banco.add(new Pessoas(4, "Matheus", 18));
    banco.add(new Pessoas(5, "Pablo", 16));

    String continuar;

    do {
        IO.println("Digite o ID da pessoa que deseja buscar: ");
        int id = scanner.nextInt();

        Pessoas pessoaEncontrada = null;

        for (Pessoas p : cache) {
            if (p.getId() == id) {
                pessoaEncontrada = p;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);
        } else {
            for (Pessoas p : banco) {
                if (p.getId() == id) {
                    pessoaEncontrada = p;
                    break;
                }
            }
        }

        if (pessoaEncontrada != null) {
            if (cache.size() >= 10) {
                Pessoas removida = cache.remove(0);
                IO.println(" * Cache cheio! Removendo pessoa com ID mais antigo: " + removida.getNome());
            }

            if (pessoaEncontrada != null) {
                cache.add(pessoaEncontrada);
                IO.println("Pessoa achada no banco. Adicionando ao cache: " + pessoaEncontrada);
            } else {
                IO.println("Pessoa não encontrada no banco e nem no cache. Verifique o ID usado.");
            }
        }


        IO.println("\n Pessoas no cache: ");
        if (cache.isEmpty()) {
            IO.println("(Cache vazio)");
        } else {
            for (Pessoas p : cache) {
                IO.println(" - " + p.getNome() + " | Idade: " + p.getIdade() + " anos|");
            }
        }
        IO.println("\nDeseja buscar outra pessoa ou tentar novamente? (Sim/Não): ");
        continuar = scanner.next();

    }
    while (continuar.equalsIgnoreCase("Sim"));

    IO.println("\nPrograma finalizado...");
}