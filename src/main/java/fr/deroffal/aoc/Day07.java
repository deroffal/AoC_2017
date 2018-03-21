package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.deroffal.aoc.bean.Programm;
import fr.deroffal.aoc.util.Utils;

public class Day07 {

	private static final String PARENT_SIGN = "-> ";

	public static void main(String[] args) {
		final List<String> programms = Utils.readLines("day07.txt");

		final Map<String, Programm> programmsByName = getProgrammByNames(programms);
		final Programm root = findRoot(programmsByName, programms);

		System.out.println("Partie 1 : " + root.getName());
		System.out.println("Partie 2 : " + part2(programms, programmsByName, root));

	}

	public static Map<String, Programm> getProgrammByNames(final List<String> programms) {
		return programms.stream().map(s -> s.split(" ")).collect(Collectors.toMap(tab -> tab[0], tab -> {
			final String name = tab[0];
			final int weight = Integer.parseInt(tab[1].substring(1, tab[1].length() - 1));
			return new Programm(name, weight);
		}));
	}

	public static Programm findRoot(final Map<String, Programm> programmsByName, final List<String> programms) {
		//Parmis l'input, on cherche le premier (qui est le seul) programme vérifiant isProgrammeRoot (ie qui n'est pas dans la partie après '-> ').
		return programmsByName.entrySet().stream().filter(entry -> isProgrammeRoot(programms, entry.getKey())).findFirst().map(Map.Entry::getValue).orElse(null);
	}

	private static boolean isProgrammeRoot(final List<String> programms, final String name) {
		return programms.stream().noneMatch(line -> line.contains(PARENT_SIGN) && line.substring(line.indexOf(PARENT_SIGN)).contains(name));
	}

	private static int part2(final List<String> programms, final Map<String, Programm> programmsByName, final Programm root) {
		//Ajouter à chaque père ses enfants et à chaque enfant son père
		fillChildrenAndParents(programms, programmsByName);

		//Trouver le programme posant problème
		final Programm oddSon = findOddSon(root);

		//Trouver les poids du programme (+ fils) qui pose problème, ainsi que celui de ses frères (+fils) qu'il devrait avoir
		final List<Integer> poids =
				oddSon.getParent().getChildren().stream().collect(Collectors.groupingBy(Programm::computeTotalWeight)).keySet().stream().sorted().collect(Collectors.toList());

		return oddSon.getWeight() - (poids.get(1) - poids.get(0));
	}

	private static void fillChildrenAndParents(final List<String> programms, final Map<String, Programm> programmsByName) {
		programms.stream().filter(prog -> prog.contains(PARENT_SIGN)).forEach(prog -> {
			final String name = prog.substring(0, prog.indexOf(' '));
			final Programm parent = programmsByName.get(name);

			final String[] childrenNames = prog.substring(prog.indexOf(PARENT_SIGN) + PARENT_SIGN.length()).split(", ");
			for (final String childName : childrenNames) {
				parent.addChild(programmsByName.get(childName));
			}
		});
	}

	private static Programm findOddSon(Programm root) {
		while (true) {
			final List<Programm> children = root.getChildren();

			//Une map des programmes enfants ordonnée par leur poid
			Map<Integer, List<Programm>> childrenProgrammsByWeight = new HashMap<>();
			children.forEach(child -> childrenProgrammsByWeight.computeIfAbsent(child.computeTotalWeight(), k -> new ArrayList<>()).add(child));

			//Si on a plus d'une entrée, on va chercher dans la famille de celui qui est seul
			if (childrenProgrammsByWeight.size() > 1) {
				for (final Map.Entry<Integer, List<Programm>> entry : childrenProgrammsByWeight.entrySet()) {
					if (entry.getValue().size() == 1) {
						root = entry.getValue().get(0);
						break;
					}
				}
			} else {
				return root;
			}
		}
	}

}
