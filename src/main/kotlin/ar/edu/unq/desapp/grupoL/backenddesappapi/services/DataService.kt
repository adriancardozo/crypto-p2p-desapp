package ar.edu.unq.desapp.grupoL.backenddesappapi.services

import ar.edu.unq.desapp.grupoL.backenddesappapi.model.Activity
import ar.edu.unq.desapp.grupoL.backenddesappapi.model.CryptoCurrency
import ar.edu.unq.desapp.grupoL.backenddesappapi.model.User
import ar.edu.unq.desapp.grupoL.backenddesappapi.repositories.ActivityRepository
import ar.edu.unq.desapp.grupoL.backenddesappapi.repositories.CryptoCurrencyRepository
import ar.edu.unq.desapp.grupoL.backenddesappapi.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.annotation.PostConstruct

@Service
class DataService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var activityRepository: ActivityRepository
    @Autowired
    private lateinit var cryptoCurrencyRepository: CryptoCurrencyRepository

    @PostConstruct
    fun initialize() {
        userRepository.save(User("A", "B", "ab@gmail.com", "ab", "ab", "1111111111111111111111", "11111111", 20, 2))
        userRepository.save(User("A", "C", "ac@gmail.com", "ac", "ac", "1111111111111111111111", "11111111", 40, 2))
        activityRepository.save(Activity(LocalDateTime.now(),
            cryptoCurrencyRepository.save(CryptoCurrency("BTCUSDT", 3000.0, System.currentTimeMillis())),
            userRepository.findByEmail("ab@gmail.com"),
            20.0))
        activityRepository.save(Activity(LocalDateTime.now(),
            cryptoCurrencyRepository.save(CryptoCurrency("ETHUSDT", 3200.0, System.currentTimeMillis())),
            userRepository.findByEmail("ab@gmail.com"),
            30.0))
        activityRepository.save(Activity(LocalDateTime.now(),
            cryptoCurrencyRepository.save(CryptoCurrency("BNBUSDT", 3400.0, System.currentTimeMillis())),
            userRepository.findByEmail("ab@gmail.com"),
            40.0))
        activityRepository.save(Activity(LocalDateTime.now(),
            cryptoCurrencyRepository.save(CryptoCurrency("NEOUSDT", 3500.0, System.currentTimeMillis())),
            userRepository.findByEmail("ab@gmail.com"),
            50.0))
    }
}