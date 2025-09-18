# Use official OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Install dependencies
RUN apt-get update && \
    apt-get install -y wget unzip curl git && \
    rm -rf /var/lib/apt/lists/*

# Set Android SDK root
ENV ANDROID_SDK_ROOT=/opt/android-sdk
ENV PATH=$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$ANDROID_SDK_ROOT/platform-tools:$PATH

# Install Android command line tools
RUN mkdir -p $ANDROID_SDK_ROOT/cmdline-tools && \
    cd $ANDROID_SDK_ROOT/cmdline-tools && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip -O cmdline-tools.zip && \
    unzip cmdline-tools.zip && \
    mv cmdline-tools $ANDROID_SDK_ROOT/cmdline-tools/latest && \
    rm cmdline-tools.zip

# Accept licenses automatically
RUN yes | sdkmanager --licenses

# Install required SDK packages
RUN sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"

# Set working directory
WORKDIR /workspace

# By default, run gradlew
ENTRYPOINT ["./gradlew"]
