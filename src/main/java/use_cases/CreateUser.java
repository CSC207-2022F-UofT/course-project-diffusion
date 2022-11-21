//package use_cases;
//
//import entities.SiteUser;
//import ports.IdGenerator;
//import ports.PasswordEncoder;
//import ports.SiteUserRepository;
//
//public class CreateUser {
//    private final SiteUserRepository repository;
//    private final PasswordEncoder passwordEncoder;
//    private final ports.IdGenerator IdGenerator;
//
//    public SiteUser create(final SiteUser siteUser){
//        UserValidator.validateCreateuser(siteUser);
//        if (repository.findByEmail(user.getEmail()).isPresent()){
//            throw new UserAlreadyExistsException(User.getEmail());
//        }
//        var saveUser = SiteUser.builder()
//                .id(idGenerator.generate())
//                .build();
//        return repository.create(saveUser);
//    }
//}
