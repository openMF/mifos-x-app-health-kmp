# App Health KMP

App Health KMP is a comprehensive toolkit for Kotlin Multiplatform projects that helps developers monitor, analyze, and improve their applications across all supported platforms.

## Features

### Firebase Analytics Integration
- Seamless integration with Firebase Analytics for KMP projects
- Cross-platform event tracking and user properties
- Consistent analytics API across all platforms (iOS, Android, Desktop, Web)
- Custom event mapping and transformation

### Unified Logging System
- Platform-agnostic logging framework
- Configurable log levels and categories
- Log forwarding to crash reporting services
- Thread-safe logging with minimal performance impact

### Code Quality Analysis
- Static code analysis to identify:
  - Duplicate code blocks
  - Potential memory leaks
  - Performance bottlenecks
  - Deprecated API usage
- Integration with build pipeline for continuous quality checks
- Detailed reports with severity levels and suggested fixes

### Crash Analysis and Resolution
- Advanced Firebase Crashlytics integration
- AI-powered crash pattern recognition
- Stack trace analysis with exact line number identification
- Automatic suggestion of potential fixes based on common patterns
- Crash grouping by root causes

### Performance Monitoring
- UI rendering performance metrics
- Network call latency tracking
- Memory usage analysis
- CPU and battery consumption insights
- Custom performance markers for critical code paths

### Developer Productivity Tools
- Build time optimization suggestions
- Dependency analysis and update recommendations
- Code health score with historical tracking
- Automated refactoring suggestions

## Getting Started

### Installation

Add the dependency to your `build.gradle.kts` file:

```kotlin
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.apphealth:apphealth-kmp:1.0.0")
            }
        }
    }
}
```

### Basic Configuration

```kotlin
// In your common code
fun initializeAppHealth() {
    AppHealth.initialize(
        config = AppHealthConfig(
            applicationId = "your-app-id",
            enableCrashReporting = true,
            enableAnalytics = true,
            enableCodeAnalysis = true,
            logLevel = LogLevel.INFO
        )
    )
}
```

## Usage Examples

### Analytics Tracking

```kotlin
// Track a simple event
AppHealth.analytics.trackEvent("button_click")

// Track an event with parameters
AppHealth.analytics.trackEvent("item_purchase", mapOf(
    "item_id" to "12345",
    "item_name" to "Premium Subscription",
    "price" to 9.99
))

// Track user properties
AppHealth.analytics.setUserProperty("subscription_tier", "premium")
```

### Logging

```kotlin
// Different log levels
AppHealth.logger.debug("Debug message")
AppHealth.logger.info("Info message")
AppHealth.logger.warning("Warning message")
AppHealth.logger.error("Error message", exception)

// Tagged logging
val networkLogger = AppHealth.logger.withTag("NETWORK")
networkLogger.info("API call started")
```

### Code Analysis

```kotlin
// Run code analysis
val analysisReport = AppHealth.codeAnalyzer.analyze(
    scope = AnalysisScope.FULL_PROJECT,
    options = AnalysisOptions(
        checkDuplicates = true,
        checkMemoryLeaks = true,
        checkPerformance = true
    )
)

// Process results
analysisReport.issues.forEach { issue ->
    println("${issue.severity}: ${issue.message} at ${issue.location}")
    
    // Apply suggested fix if available
    if (issue.hasSuggestedFix()) {
        issue.applySuggestedFix()
    }
}
```

### Crash Analysis

```kotlin
// Get insights from recent crashes
val crashInsights = AppHealth.crashAnalyzer.getInsights()

crashInsights.forEach { insight ->
    println("Crash pattern: ${insight.pattern}")
    println("Affected code: ${insight.codeLocation}")
    println("Suggested fix: ${insight.suggestedFix}")
    
    // Apply the suggested fix
    if (insight.canAutoFix) {
        insight.applyFix()
    }
}
```

## Advanced Configuration

### Custom Analytics Transformation

```kotlin
AppHealth.analytics.configure {
    // Transform events before sending to Firebase
    eventTransformer = { name, params ->
        // Prefix all event names
        val newName = "app_$name"
        
        // Add common parameters to all events
        val newParams = params + mapOf(
            "app_version" to getAppVersion(),
            "platform" to getPlatformName()
        )
        
        EventTransformation(newName, newParams)
    }
}
```

### Performance Monitoring Points

```kotlin
// Track performance of a code block
AppHealth.performance.trackBlock("image_processing") {
    // Your code here
    processImage(bitmap)
}

// Track network requests
AppHealth.performance.trackNetworkCall(url, method) {
    // Your network call
    api.fetchData()
}
```

## Platform-Specific Extensions

App Health KMP provides platform-specific extensions for deeper integration:

### Android
- UI thread monitoring
- Activity lifecycle tracking
- Android-specific memory analysis

### iOS
- UIViewController monitoring
- iOS memory pressure handling
- SwiftUI integration

### Desktop/Web
- Browser performance integration
- Desktop memory and CPU monitoring
- Web-specific crash handling

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
