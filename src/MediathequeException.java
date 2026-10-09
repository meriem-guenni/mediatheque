/*
 * Choix : exceptions CHECKED (extends Exception).
 *
 * Justification : un document indisponible ou introuvable est un cas métier
 * prévisible, pas un bug de programmation. L'appelant doit donc être obligé
 * de le traiter (try/catch ou throws), et le compilateur le vérifie.
 * Une exception unchecked (RuntimeException) serait adaptée à une erreur
 * de programmation (ex. argument null), pas à une situation normale de la médiathèque.
 */
public class MediathequeException extends Exception{
public MediathequeException(String message){
    super(message);

}public MediathequeException(String message,Throwable cause){
    super(message,cause);
    }
}
